package app.school.administration.school.api.controller;

import app.school.administration.school.application.serviceimpl.SchoolServiceImpl;
import app.school.administration.school.infrastructure.persistance.entity.SchoolEntity;
import app.school.administration.school.infrastructure.persistance.projection.SchoolProjectionDTO;
import app.school.administration.common.utils.AppCommonEndPoint;
import app.school.administration.common.utils.AppModuleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppModuleApi.AUTH)
public class SchoolController {

    private final SchoolServiceImpl schoolService;

    @GetMapping(AppCommonEndPoint.FIND_BY_ID)
    public ResponseEntity<SchoolProjectionDTO> findById(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(schoolService.findByIdProjection(uuid));
    }

    @PostMapping(AppCommonEndPoint.CREATE)
    public ResponseEntity<SchoolEntity> create(@RequestBody SchoolEntity schoolEntity) {
        return ResponseEntity.ok(schoolService.save(schoolEntity));
    }

    @PutMapping(AppCommonEndPoint.UPDATE)
    public ResponseEntity<SchoolEntity> update(@RequestBody SchoolEntity schoolEntity) {
        return ResponseEntity.ok(schoolService.save(schoolEntity));
    }

    @PutMapping(AppCommonEndPoint.DE_ACTIVATE)
    public ResponseEntity<SchoolEntity> deActivate(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(schoolService.deActivate(uuid));
    }

}
