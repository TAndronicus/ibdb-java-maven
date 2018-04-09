package ibdb.controller;

import ibdb.model.dao.BookDao;
import ibdb.model.dao.MarkDao;
import ibdb.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/{id}")
    public String getUserSurnameFromId(@PathVariable long id) {
        return bookService.getBookById(id).toString();
    }

    @RequestMapping("/all")
    public List<BookDao> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("marks/{id}")
    public List<MarkDao> getAllMarks(@PathVariable long id) {
        return bookService.getAllMarks(id);
    }

    @RequestMapping("/save/{title}/{author}/{category}")
    public BookDao saveByTitleAuthorCategory(@PathVariable String title, @PathVariable long author, @PathVariable short category) {
        long[] authors = {author};
        short[] categories = {category};
        BookDao bookDao = new BookDao(title, authors, categories);
        return bookService.save(bookDao);
    }

}
