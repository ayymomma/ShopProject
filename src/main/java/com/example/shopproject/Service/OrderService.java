package com.example.shopproject.Service;

import com.example.shopproject.Mapper.BookMapper;
import com.example.shopproject.Mapper.OrderMapper;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Model.Entity.Book;
import com.example.shopproject.Model.Entity.Item;
import com.example.shopproject.Model.Entity.Order;
import com.example.shopproject.Repository.BookRepository;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(),
            "pos_orders"));

    @Autowired
    BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    public void PostOrder(PostOrderDTO postOrderDTO, Integer idUser) {
        Order order= OrderMapper.convertToOrder(postOrderDTO);
        for (Item item :
                order.getItems()
             ) {
            BookDTO book = bookService.GetBookByIsbn(item.getIsbn());
            Integer stock = bookService.GetStockByISBN(item.getIsbn());
            if(book !=  null)
            {
                if(stock >= item.getAmount())
                {
                    book.setStock(stock - item.getAmount());
                    bookRepository.save(BookMapper.convertToBook(book));
                    continue;
                }
            }
            List<Item> list = order.getItems();
            list.remove(item);
            order.setItems(list);
        }
        mongoOps.insert(order,"Client."+idUser);
    }

    public void DeleteAllOrders(Integer idUser){
        mongoOps.dropCollection("Client."+idUser);
    }
}