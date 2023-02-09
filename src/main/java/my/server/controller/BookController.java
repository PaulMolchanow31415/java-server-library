package my.server.controller;

import my.server.entity.BookEntity;
import my.server.exception.EmptyDataBaseException;
import my.server.exception.IllegalBookDataException;
import my.server.response.BaseResponse;
import my.server.response.BookListResponse;
import my.server.service.BookService;
import my.server.utils.BookUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) { this.service = service; }

    @PostMapping("/add")
    public ResponseEntity <BaseResponse> registration(@RequestBody BookEntity data) {
        try {
            if (BookUtils.fullValidate(data)){
                throw new IllegalBookDataException("Ошибки в данных книги");
            } else {
                service.save(data);
            }

            return ResponseEntity.ok(new BaseResponse(true, "Книга добавлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data) {
        try {
            if (BookUtils.fullValidate(data)){
                throw new IllegalBookDataException("Ошибки в данных книги");
            } else {
                service.save(data);
            }

            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        try {
            if (!service.getAll().iterator().hasNext()) {
                throw new EmptyDataBaseException("База пуста");
            }

            return ResponseEntity.ok(new BookListResponse(service.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }

   /* @DeleteMapping("/deleteById/{id}")
    public ResponseEntity <BaseResponse> delete() {
        try {
            if (!service.getAll().iterator().hasNext()) {
                throw new EmptyDataBaseException("База пуста");
            }

            return ResponseEntity.ok(new BookListResponse(service.delete(id);))
        } catch (EmptyDataBaseException e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Операция завершена");
        }
    }*/
}
