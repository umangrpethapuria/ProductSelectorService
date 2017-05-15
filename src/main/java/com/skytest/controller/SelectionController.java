package com.skytest.controller;

import com.skytest.dto.ProductsDTO;
import com.skytest.service.CatalogueService;
import com.skytest.service.CustomerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SelectionController {

    @Autowired
    private CustomerLocationService customerLocationService;

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping(path = "/customer/location", method = RequestMethod.GET)
    public @ResponseBody Long getLocation(@CookieValue("customerId") Long customerId){
        return customerLocationService.getLocationIdForCustomer(customerId);
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public @ResponseBody ProductsDTO getProducts(@CookieValue("locationId") Long locationId){
        return catalogueService.getProducts(locationId);
    }

    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public String confirmSelection(@CookieValue("customerId") Long customerId, ProductsDTO productsDTO){
        return "Product selection saved";
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST,
            reason="Bad Request")  // 400
    @ExceptionHandler
    public String handleException(Exception e) {
        return e.getMessage();
    }


}
