package com.simwor.myselfop.integration.volksbook;

import com.simwor.volksbook.bean.Book;

public interface BookIntegration {

    Book queryByIsbn(String isbn);

}
