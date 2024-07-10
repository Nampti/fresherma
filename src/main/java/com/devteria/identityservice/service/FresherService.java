// package com.devteria.identityservice.service;

// import com.devteria.identityservice.dto.request.FresherCreationRequest;
// import com.devteria.identityservice.dto.response.FresherResponse;
// import com.devteria.identityservice.dto.request.FresherScoreUpdateRequest;
// import com.devteria.identityservice.entity.Fresher;
// import com.devteria.identityservice.exception.AppException;
// import com.devteria.identityservice.exception.ErrorCode;
// import com.devteria.identityservice.mapper.FresherMapper;
// import com.devteria.identityservice.repository.FresherRepository;
// import com.devteria.identityservice.repository.UserRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// @RequiredArgsConstructor
// public class FresherService {
//     private final FresherRepository fresherRepository;
//     private final UserRepository userRepository;
//     private final FresherMapper fresherMapper;

//     public List<FresherResponse> getAllFreshers() {
//         return fresherRepository.findAll().stream()
//                 .map(fresherMapper::toFresherResponse)
//                 .collect(Collectors.toList());
//     }

//     public FresherResponse createFresher(FresherCreationRequest request) {
      
//             Fresher fresher = fresherMapper.toFresher(request);
//             return fresherMapper.toFresherResponse(fresherRepository.save(fresher));
//     }

//    public FresherResponse updateFresherScore(String fresherId, FresherScoreUpdateRequest request) {
//     Fresher fresher = fresherRepository.findById(fresherId)
//             .orElseThrow(() -> new AppException(ErrorCode.FRESHER_NOT_FOUND));
    
   
//     if (fresher.getProjectScores() == null) {
//         fresher.setProjectScores(new ArrayList<>());
//     }
    
   
//     fresher.getProjectScores().add(request.getScore());
//     fresher.calculateAndUpdateFinalAverageScore();
//     return fresherMapper.toFresherResponse(fresherRepository.save(fresher));
// }

//     public void deleteFresher(String fresherId) {
//         if (!fresherRepository.existsById(fresherId)) {
//             throw new AppException(ErrorCode.FRESHER_NOT_FOUND);
//         }
//         fresherRepository.deleteById(fresherId);
//     }

// }