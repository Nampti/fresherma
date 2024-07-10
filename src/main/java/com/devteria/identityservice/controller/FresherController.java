package com.devteria.identityservice.controller;

import com.devteria.identityservice.dto.request.ApiResponse;
import com.devteria.identityservice.dto.request.FresherCreationRequest;
import com.devteria.identityservice.dto.request.FresherScoreUpdateRequest;
import com.devteria.identityservice.dto.response.FresherResponse;
import com.devteria.identityservice.service.FresherService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freshers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FresherController {
    final FresherService fresherService;

    @PostMapping
    ApiResponse<FresherResponse> createFresher(@RequestBody @Valid FresherCreationRequest request) {
        return ApiResponse.<FresherResponse>builder()
                .result(fresherService.createFresher(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<FresherResponse>> getAllFreshers() {
        return ApiResponse.<List<FresherResponse>>builder()
                .result(fresherService.getAllFreshers())
                .build();
    }

}