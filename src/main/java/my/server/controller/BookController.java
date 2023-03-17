package my.server.controller;

import my.server.entity.BookEntity;
import my.server.response.BaseResponse;
import my.server.response.BookEntityResponse;
import my.server.response.BookListResponse;
import my.server.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    private BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    private ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new BookListResponse(service.getAll()));
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
            return ResponseEntity.ok(new BookListResponse(service.findAll(query)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Поиск данных в БД завершен");
        }
    }

    @PostMapping("/add")
    private ResponseEntity<BookEntityResponse> registration(@Valid @RequestBody BookEntity data) {
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
    private ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
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
            service.delete(id, param);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена из БД"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Удаление завершено");
        }
    }
}
