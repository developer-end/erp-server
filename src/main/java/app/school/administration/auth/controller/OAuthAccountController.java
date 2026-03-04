package app.school.administration.auth.controller;

import app.school.administration.auth.entity.OAuthAccountEntity;
import app.school.administration.auth.projection.OAuthAccountProjectionDTO;
import app.school.administration.auth.serviceimpl.OAuthUserServiceImpl;
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
@RequestMapping(AppModuleApi.O_AUTH)
public class OAuthAccountController {

    private final OAuthUserServiceImpl oAuthUserService;

    @GetMapping(AppCommonEndPoint.FIND_BY_ID)
    public ResponseEntity<OAuthAccountProjectionDTO> findById(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(oAuthUserService.findByIdProjection(uuid));
    }

    @PostMapping(AppCommonEndPoint.CREATE)
    public ResponseEntity<OAuthAccountEntity> create(@RequestBody OAuthAccountEntity schoolEntity) {
        return ResponseEntity.ok(oAuthUserService.save(schoolEntity));
    }

    @PutMapping(AppCommonEndPoint.UPDATE)
    public ResponseEntity<OAuthAccountEntity> update(@RequestBody OAuthAccountEntity schoolEntity) {
        return ResponseEntity.ok(oAuthUserService.save(schoolEntity));
    }

    @PutMapping(AppCommonEndPoint.DE_ACTIVATE)
    public ResponseEntity<OAuthAccountEntity> deActivate(@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(oAuthUserService.deActivate(uuid));
    }

}
