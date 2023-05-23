//package com.example.customers.service
//
//import com.example.customers.client.FraudClient
//import com.example.customers.config.ApplicationProperties
//import com.example.customers.dao.entity.CustomerEntity
//import com.example.customers.dao.repository.CustomerRepository
//import com.example.customers.dto.request.CustomerRegistrationRequestDto
//import com.example.customers.dto.request.NotificationRequest
//import com.example.customers.dto.response.FraudCheckResponse
//import com.example.customers.producer.RabbitMQMessageProducer
//import spock.lang.Specification
//
//class CustomerServiceTest extends Specification {
//    private CustomerService customerService
//    private CustomerRepository customerRepository
//    private FraudClient fraudClient
//    RabbitMQMessageProducer rabbitMQMessageProducer
//    ApplicationProperties applicationProperties
//
//    def setup() {
//        customerRepository = Mock(CustomerRepository)
//        fraudClient = Mock(FraudClient)
//        rabbitMQMessageProducer = Mock(RabbitMQMessageProducer)
//        applicationProperties = Mock(ApplicationProperties)
//
//        customerService = new CustomerService(
//                customerRepository,
//                fraudClient,
//                rabbitMQMessageProducer,
//                applicationProperties
//        )
//    }
//
//    def "should register customer successfully"() {
//        given:
//        CustomerRegistrationRequestDto customerRequest = new CustomerRegistrationRequestDto(
//                "John",
//                "Doe",
//                "john.doe@example.com"
//        )
//        FraudCheckResponse fraudCheckResponse = new FraudCheckResponse(false)
//
//        customerRepository.saveAndFlush(_ as CustomerEntity) >> {
//            CustomerEntity entity ->
//                entity.id = 1 entity
//        }
//
//        fraudClient.isFraudster(1) >> fraudCheckResponse
//
//        NotificationRequest capturedNotificationRequest
//
//        rabbitMQMessageProducer.publish(_, _ as String, _ as String) >> {
//            NotificationRequest request -> capturedNotificationRequest = request
//        }
//
//        when:
//        customerService.registerCustomer(customerRequest)
//
//        then:
//        1 * customerRepository.saveAndFlush(_ as CustomerEntity)
//        1 * fraudClient.isFraudster(1)
//        1 * rabbitMQMessageProducer.publish(_, _, _)
//
//        capturedNotificationRequest.getToCustomerId() == 1
//        capturedNotificationRequest.getToCustomerName() == "John"
//        capturedNotificationRequest.getToCustomerEmail() == "john.doe@example.com"
//        capturedNotificationRequest.getMessage().startsWith("Hi John")
//    }
//
//    def "should throw an exception when customer is a fraudster"() {
//        given:
//        CustomerRegistrationRequestDto request = new CustomerRegistrationRequestDto(
//                "Jane",
//                "Smith",
//                "jane.smith@example.com"
//        )
//
//        FraudCheckResponse fraudCheckResponse = new FraudCheckResponse(true)
//
//        fraudClient.isFraudster(_ as Long) >> fraudCheckResponse
//
//        when:
//        customerService.registerCustomer(request)
//
//        then:
//        0 * customerRepository.saveAndFlush(_ as CustomerEntity)
//        1 * fraudClient.isFraudster(_)
//
//        def exception = thrown(IllegalStateException)
//        exception.message == "fraudster"
//    }
//
//}