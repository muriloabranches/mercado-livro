package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO,
        password = this.password
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        previousValue.id,
        this.name,
        this.email,
        previousValue.status,
        previousValue.password
    )
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        previousValue.id,
        this.name ?: previousValue.name,
        this.price ?: previousValue.price,
        previousValue.customer,
        previousValue.status,
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        this.id,
        this.name,
        this.email,
        this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        this.id,
        this.name,
        this.price,
        this.customer,
        this.status
    )
}