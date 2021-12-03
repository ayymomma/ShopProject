package com.example.shopproject.Service;

import com.example.shopproject.Mapper.OrderMapper;
import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Model.Entity.Order;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(),
            "pos_orders"));


    public void PostOrder(PostOrderDTO postOrderDTO, Integer idUser) {
        Order order= OrderMapper.convertToOrder(postOrderDTO);
        mongoOps.insert(order,"Client."+idUser);
    }

    public void DeleteAllOrders(Integer idUser){
        mongoOps.dropCollection("Client."+idUser);
    }
}