package my.server.controller;

import my.server.entity.BookEntity;
import my.server.response.BaseResponse;
import my.server.response.BookEntityResponse;
import my.server.response.BookListResponse;
import my.server.service.AuthorService;
import my.server.service.BookService;
import my.server.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping("/all")
    private ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new BookListResponse(bookService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Взятие данных из БД завершено");
        }
    }

    @GetMapping("/retrieveAll")
    /* api/v1/book/retrieveAll?query=abc */
    private ResponseEntity<BaseResponse> retrieveAll(@RequestParam String query) {
        try {
            return ResponseEntity.ok(new BookListResponse(bookService.findAll(query)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Поиск данных в БД завершен");
        }
    }

    @PostMapping("/add")
    private ResponseEntity<BookEntityResponse> registration(@Valid @RequestBody BookEntity data) {
        try {
            authorService.save(data.getAuthor());
            publisherService.save(data.getPublisher());
            bookService.save(data);
            return ResponseEntity.ok(new BookEntityResponse(true, "Книга добавлена", data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BookEntityResponse(false, e.getMessage(), null));
        } finally {
            System.out.println("Сохранение завершено");
        }
    }

    @PutMapping("/update")
    private ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            bookService.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Обновление завершено");
        }
    }

    @DeleteMapping("/delete")
    private ResponseEntity<BaseResponse> delete(@RequestParam(required = false) Long id,
                                                @RequestParam(required = false) String param) {
        try {
            bookService.delete(id, param);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена из БД"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Удаление завершено");
        }
    }
}
