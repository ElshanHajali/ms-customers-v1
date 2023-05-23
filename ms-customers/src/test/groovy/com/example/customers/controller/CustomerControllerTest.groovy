package com.example.customers.controller
//package controller
//
//import com.example.customers.controller.CustomerController
//import com.example.customers.dto.request.CustomerRegistrationRequestDto
//import com.example.customers.service.CustomerService
//import spock.lang.Specification
//
//class CustomerControllerTest extends Specification {
//    CustomerService customerService = Mock(CustomerService)
//    CustomerController customerController = new CustomerController(customerService)
//
//    def "should register customer successfully"() {
//        given:
//        def customerRegistrationRequest = new CustomerRegistrationRequestDto(
//                "John",
//                "Doe",
//                "john.doe@example.com"
//        )
//
//        when:
//        customerController.registerCustomer(customerRegistrationRequest)
//
//        then:
//        1 * customerService.registerCustomer(customerRegistrationRequest)
//    }
//
//    def "should return 500 Internal Server Error when an exception occurs during registration"() {
//        given:
//        def customerRegistrationRequest = new CustomerRegistrationRequestDto(
//                "Jane",
//                "Smith",
//                "jane.smith@example.com"
//        )
//
//        customerService.registerCustomer(_ as CustomerRegistrationRequestDto) >> { throw new IllegalStateException("Failed to register customer") }
//
//        when:
//        def responseException = capture(ResponseStatusException) {
//            customerController.registerCustomer(customerRegistrationRequest)
//        }
//
//        then:
//        1 * customerService.registerCustomer(customerRegistrationRequest)
//
//        responseException.status == HttpStatus.INTERNAL_SERVER_ERROR
//        responseException.reason == "Failed to register customer"
//    }
//}
