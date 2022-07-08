package com.mercadolivro.validation

import com.mercadolivro.service.BookService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class BooksAvailableValidator(
    private val bookService: BookService
) : ConstraintValidator<BooksAvailable, Set<Int>> {

    override fun isValid(value: Set<Int>?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }

        for (bookId in value) {
            if (!bookService.bookAvailable(bookId)) {
                return false
            }
        }

        return true
    }
}
