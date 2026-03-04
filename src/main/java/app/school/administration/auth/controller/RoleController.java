package app.school.administration.auth.controller;

import app.school.administration.auth.entity.RoleEntity;
import app.school.administration.auth.projection.RoleProjectionDTO;
import app.school.administration.auth.serviceimpl.RoleServiceImpl;
import app.school.administration.auth.utils.AppCommonEndPoint;
import app.school.administration.auth.utils.AppModuleApi;
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
@RequestMapping(AppModuleApi.ROLE)
public class RoleController {

    private final RoleServiceImpl roleService;

    @GetMapping(AppCommonEndPoint.FIND_BY_ID)
    public ResponseEntity<RoleProjectionDTO> findById(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(roleService.findByIdProjection(uuid));
    }

    @PostMapping(AppCommonEndPoint.CREATE)
    public ResponseEntity<RoleEntity> create(@RequestBody RoleEntity roleEntity) {
        return ResponseEntity.ok(roleService.save(roleEntity));
    }

    @PutMapping(AppCommonEndPoint.UPDATE)
    public ResponseEntity<RoleEntity> update(@RequestBody RoleEntity roleEntity) {
        return ResponseEntity.ok(roleService.save(roleEntity));
    }

    @PutMapping(AppCommonEndPoint.DE_ACTIVATE)
    public ResponseEntity<RoleEntity> deActivate(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(roleService.deActivate(uuid));
    }

}
