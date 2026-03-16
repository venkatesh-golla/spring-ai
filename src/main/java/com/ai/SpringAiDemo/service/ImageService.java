package com.ai.SpringAiDemo.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    //    Grok does not support Image generation, we would need to use OpenAI's API key in application.properties for this functionality
    private final OpenAiImageModel imageModel;

    @Autowired
    public ImageService(OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageResponse generateImage(String prompt) {
        return imageModel.call(
                new ImagePrompt(prompt)
        );
    }

    public ImageResponse generateImageOptions(String prompt, String quality, int height, int width, int n) {
        return imageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .withQuality(quality)
                                .withHeight(height)
                                .withWidth(width)
                                .withN(n)
                                .build()
                ));
    }
}
