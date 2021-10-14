package com.example.ObaProject.services;

import com.example.ObaProject.response.BoekResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

    @InjectMocks
    private BookService underTest;

//    BookServiceTest(BookService underTest) {
//        this.underTest = underTest;
//    }

//    @BeforeEach
//    void BookServiceTest(BookService underTest) {
//        this.underTest = underTest;
//    }


    @Test
    void getBooks() {

//        Mockito.when(underTest.getBooks("&refine=true", 1)).thenReturn(new BoekResponse());

//        BoekResponse response = underTest.getBooks("&refine=true", 1);
//        assertThat(response).isInstanceOfAny(BoekResponse.class);
//        assertThat(response).asInstanceOf(BoekResponse.class);
//        assertThat(response).isInstanceOfAny(BoekResponse.class);
    }


}