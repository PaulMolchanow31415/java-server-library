package my.server.controller;

import my.server.entity.AuthorEntity;
import my.server.response.AuthorEntityResponse;
import my.server.response.AuthorListResponse;
import my.server.response.BaseResponse;
import my.server.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService service;

    private AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/retrieveSuitable")
    private ResponseEntity<BaseResponse> retrieveAll(@RequestParam String query) {
        /* api/v1/author/retrieveSuitable?query=abc */
        try {
            return ResponseEntity.ok(new AuthorListResponse(service.findAll(query)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Поиск данных в БД завершен");
        }
    }

    @GetMapping("/all")
    private ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new AuthorListResponse(service.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Взятие данных из БД завершено");
        }
    }

    @PostMapping("/add")
    private ResponseEntity<AuthorEntityResponse> checkIn(@Valid @RequestBody AuthorEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new AuthorEntityResponse(true, "Автор добавлен", data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthorEntityResponse(false, e.getMessage(), null));
        } finally {
            System.out.println("Сохранение завершено");
        }
    }

    @PutMapping("/update")
    private ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Автор успешно изменен"));
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
            return ResponseEntity.ok(new BaseResponse(true, "Автор удален из БД"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Удаление завершено");
        }
    }
}
