package app.school.administration.institution.api.controller;

import app.school.administration.institution.application.serviceimpl.InstitutionServiceImpl;
import app.school.administration.institution.infrastructure.persistance.entity.InstitutionEntity;
import app.school.administration.institution.infrastructure.persistance.projection.InstitutionProjectionDTO;
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
@RequestMapping(AppModuleApi.INSTITUTION)
public class InstitutionController {

    private final InstitutionServiceImpl institutionService;

    @GetMapping(AppCommonEndPoint.FIND_BY_ID)
    public ResponseEntity<InstitutionProjectionDTO> findById(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(institutionService.findByIdProjection(uuid));
    }

    @PostMapping(AppCommonEndPoint.CREATE)
    public ResponseEntity<InstitutionEntity> create(@RequestBody InstitutionEntity schoolEntity) {
        return ResponseEntity.ok(institutionService.save(schoolEntity));
    }

    @PutMapping(AppCommonEndPoint.UPDATE)
    public ResponseEntity<InstitutionEntity> update(@RequestBody InstitutionEntity schoolEntity) {
        return ResponseEntity.ok(institutionService.save(schoolEntity));
    }

    @PutMapping(AppCommonEndPoint.DE_ACTIVATE)
    public ResponseEntity<InstitutionEntity> deActivate(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(institutionService.deActivate(uuid));
    }

}
