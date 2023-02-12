package my.server.controller;

import my.server.entity.BookEntity;
import my.server.response.BaseResponse;
import my.server.response.BookEntityResponse;
import my.server.response.BookListResponse;
import my.server.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> registration(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Книга добавлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new BookListResponse(service.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/search-by-title/{title}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getBooksByTitle(@PathVariable String title) {
        try {
            return ResponseEntity.ok(new BookEntityResponse(service.getBooksByTitle(title)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/search-by-author/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getBooksByAuthorName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(new BookEntityResponse(service.getBooksByAuthor(name)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/search-by-publisher/{publisher}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getBooksByPublisher(@PathVariable String publisher) {
        try {
            return ResponseEntity.ok(new BookEntityResponse(service.getBooksByPublisher(publisher)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/search-by-year/{year}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getBooksByYearPub(@PathVariable String year) {
        try {
            return ResponseEntity.ok(new BookEntityResponse(service.getBooksByYearPub(year)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/search-by-kind/{kind}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getBooksByKind(@PathVariable String kind) {
        try {
            return ResponseEntity.ok(new BookEntityResponse(service.getBooksByKind(kind)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена из БД"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }
}
