package app.school.administration.auth.api.controller;

import app.school.administration.auth.application.serviceimpl.TenantServiceImpl;
import app.school.administration.auth.infrastructure.persistence.entity.TenantEntity;
import app.school.administration.auth.infrastructure.persistence.projection.TenantProjectionDTO;
import app.school.administration.common.utils.AppCommonEndPoint;
import app.school.administration.common.utils.AppModuleApi;
import app.school.administration.school.infrastructure.persistance.entity.embeddable.TenantSchoolId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping(AppModuleApi.TENANT)
public class TenantController {

    private final TenantServiceImpl tenantService;

    @GetMapping(AppCommonEndPoint.FIND_BY_ID)
    public ResponseEntity<TenantProjectionDTO> findById(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(tenantService.findByIdProjection(uuid));
    }

    @PostMapping(AppCommonEndPoint.CREATE)
    public ResponseEntity<TenantEntity> create(@Validated @RequestBody TenantEntity tenantEntity) {
        return ResponseEntity.ok(tenantService.save(tenantEntity));
    }

    @PutMapping(AppCommonEndPoint.UPDATE)
    public ResponseEntity<TenantEntity> update(@Validated @RequestBody TenantEntity tenantEntity) {
        return ResponseEntity.ok(tenantService.save(tenantEntity));
    }

    @PutMapping(AppCommonEndPoint.DE_ACTIVATE)
    public ResponseEntity<TenantEntity> deActivate(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(tenantService.deActivate(uuid));
    }

    @PutMapping(AppCommonEndPoint.TENANT_SCHOOL_MAPPING_DE_ACTIVATE)
    public ResponseEntity<Void> tenantSchoolMappingDeActivate(@PathVariable(name = "uuid") TenantSchoolId uuid) {
        return ResponseEntity.ok(tenantService.tenantSchoolMappingDeActivate(uuid));
    }

}
