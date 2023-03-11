package my.server.controller;

import my.server.entity.BookEntity;
import my.server.response.BaseResponse;
import my.server.response.BookEntityResponse;
import my.server.response.BookListResponse;
import my.server.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new BookListResponse(service.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Взятие данных из БД завершено");
        }
    }

    @GetMapping("/find/{sought}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> find(@PathVariable String sought) {
        try {
            return ResponseEntity.ok(new BookListResponse(service.find(sought)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Поиск данных в БД завершен");
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookEntityResponse> registration(@Valid @RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BookEntityResponse(true, "Книга добавлена", data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BookEntityResponse(false, e.getMessage(), null));
        } finally {
            System.out.println("Сохранение завершено");
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Обновление завершено");
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
            System.out.println("Удаление завершено");
        }
    }
}
