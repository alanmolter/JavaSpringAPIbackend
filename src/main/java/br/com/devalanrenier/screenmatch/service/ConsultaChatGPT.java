package br.com.devalanrenier.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
