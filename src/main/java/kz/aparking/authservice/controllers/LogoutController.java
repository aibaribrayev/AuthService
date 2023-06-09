package kz.aparking.authservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import kz.aparking.authservice.jwt.JwtTokenUtil;
import kz.aparking.authservice.services.TokenBlacklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LogoutController {
    private final JwtTokenUtil jwtTokenUtil;
    private final TokenBlacklistService tokenBlacklistService;
    private final HttpServletRequest request;

    public LogoutController(JwtTokenUtil jwtTokenUtil, TokenBlacklistService tokenBlacklistService, HttpServletRequest request) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.tokenBlacklistService = tokenBlacklistService;
        this.request = request;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        String jwtToken = request.getHeader("Authorization").substring(7);
        tokenBlacklistService.addToBlacklist(jwtToken);
        return ResponseEntity.ok().build();
    }
}

