package my.server.controller;

import my.server.entity.PublisherEntity;
import my.server.response.BaseResponse;
import my.server.response.PublisherEntityResponse;
import my.server.response.PublisherListResponse;
import my.server.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {
    private final PublisherService service;

    private PublisherController(PublisherService service) {
        this.service = service;
    }

    @GetMapping("/all")
    private ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new PublisherListResponse(service.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Взятие данных из БД завершено");
        }
    }

    @GetMapping("/retrieveAll")
    /* api/v1/publisher/retrieveAll?query=abc */
    private ResponseEntity<BaseResponse> extractData(@RequestParam String query) {
        try {
            return ResponseEntity.ok(new PublisherListResponse(service.findAll(query)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Поиск данных в БД завершен");
        }
    }

    @PostMapping("/add")
    private ResponseEntity<PublisherEntityResponse> create(@Valid @RequestBody PublisherEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new PublisherEntityResponse(true, "Издатель добавлен", data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new PublisherEntityResponse(false, e.getMessage(), null));
        } finally {
            System.out.println("Сохранение завершено");
        }
    }

    @PutMapping("/update")
    private ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Издатель успешно изменен"));
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
            return ResponseEntity.ok(new BaseResponse(true, "Издатель удален из БД"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } finally {
            System.out.println("Удаление завершено");
        }
    }
}
