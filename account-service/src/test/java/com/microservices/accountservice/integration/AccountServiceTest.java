package com.microservices.accountservice.integration;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class AccountServiceTest {
    /*
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private IOrderRepository orderRepository;

    @Container
    static MySQLContainer mySQLContainer =  new MySQLContainer<>("mysql:latest")
            .withDatabaseName("order_service")
            .withUsername("root")
            .withPassword("admin");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
        dynamicPropertyRegistry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", mySQLContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.driver-class-name", mySQLContainer::getDriverClassName);
        dynamicPropertyRegistry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    @DisplayName("should place an order")
    public void shouldPlaceOrder() throws Exception {

        AccountRequest orderRequest = getOrderRequest();
        String orderRequestString = objectMapper.writeValueAsString(orderRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderRequestString))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1, orderRepository.findAll().size());
    }

    private AccountRequest getOrderRequest(){
        List<AccountDTO> orderLineItems = new ArrayList<>();
        AccountDTO orderLineItem = AccountDTO.builder()
                .skuCode("teclado")
                .price(BigDecimal.valueOf(130000))
                .quantity(1)
                .build();
        orderLineItems.add(orderLineItem);
        AccountRequest orderRequest = AccountRequest.builder()
                .orderLineItemsDTO(orderLineItems)
                .build();
        return orderRequest;
    }*/

}
