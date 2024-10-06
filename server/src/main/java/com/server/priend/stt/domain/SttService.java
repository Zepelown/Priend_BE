package com.server.priend.stt.domain;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import com.server.priend.stt.payload.response.post.SttResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class SttService {
    private final Logger logger = LoggerFactory.getLogger(SttService.class);

    public SttResponse transcribe(MultipartFile audioFile) throws IOException {
        if (audioFile.isEmpty()) {
            throw new IOException("Required part 'audioFile' is not present.");
        }
        // 오디오 파일을 byte array로 decode
        byte[] audioBytes = audioFile.getBytes();

        // 클라이언트 인스턴스화
        try (SpeechClient speechClient = SpeechClient.create()) {
            // 오디오 객체 생성
            ByteString audioData = ByteString.copyFrom(audioBytes);
            RecognitionAudio recognitionAudio = RecognitionAudio.newBuilder()
                    .setContent(audioData)
                    .build();

            // 설정 객체 생성
            RecognitionConfig recognitionConfig =
                    RecognitionConfig.newBuilder()
                            .setEncoding(RecognitionConfig.AudioEncoding.AMR)
                            .setSampleRateHertz(8000)
                            .setLanguageCode("ko-KR")
                            .build();

            // 오디오-텍스트 변환 수행
            RecognizeResponse response = speechClient.recognize(recognitionConfig, recognitionAudio);
            List<SpeechRecognitionResult> results = response.getResultsList();

            if (!results.isEmpty()) {
                // 주어진 말 뭉치에 대해 여러 가능한 스크립트를 제공. 0번(가장 가능성 있는)을 사용한다.
                SpeechRecognitionResult result = results.get(0);
                String transcript = result.getAlternatives(0).getTranscript();
                logger.info("Transcription result: {}", transcript);
                return new SttResponse(transcript);
            } else {
                throw new NoSuchElementException("No transcription result found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
