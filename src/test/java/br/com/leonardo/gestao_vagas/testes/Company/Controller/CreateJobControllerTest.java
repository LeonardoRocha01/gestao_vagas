package br.com.leonardo.gestao_vagas.testes.Company.Controller;

import br.com.leonardo.gestao_vagas.PrimeiroProjetoSpringbootApplication;
import br.com.leonardo.gestao_vagas.company.Entity.CompanyEntity;
import br.com.leonardo.gestao_vagas.company.repository.CompanyRespository;
import br.com.leonardo.gestao_vagas.job.DTO.CreateJobDTO;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import br.com.leonardo.gestao_vagas.testes.Utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import java.util.UUID;


@SpringBootTest(classes = PrimeiroProjetoSpringbootApplication.class)
@AutoConfigureMockMvc
public class CreateJobControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CompanyRespository companyRespository;

    @Test
    public void shouldBeAbleToCreateANewJob() throws Exception {

        var company = CompanyEntity.builder()
                .description("COMPANY_DESCRIPTION")
                .email("email@company.com")
                .password("1234567890")
                .username("COMPANY_USERNAME")
                .name("COMPANY_NAME")
                .build();

        company = companyRespository.saveAndFlush(company);

        var createJobDTO = CreateJobDTO.builder()
                .benefits("BENEFITS_TEST")
                .description("DESCRIPTION_TEST")
                .level("LEVEL_TEST")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/company/job/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.objectToJson(createJobDTO))
                        .header(
                                "Authorization",
                                TestUtils.generateToken(company.getId(), "JAVAGAS_0123#")
                        )
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void shouldNotBeAbleToCreateANewJobIfCompanyNotFound() throws Exception {
        var createJobDTO = CreateJobDTO.builder()
                .benefits("BENEFITS_TEST")
                .description("DESCRIPTION_TEST")
                .level("LEVEL_TEST").build();

      mvc.perform(MockMvcRequestBuilders.post("/company/job/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.objectToJson(createJobDTO))
                        .header("Authorization", TestUtils.generateToken(UUID.randomUUID(), "JAVAGAS_0123##")))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    private static String objectToJson(Object object){
        try{
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }catch (Exception e){
        throw new RuntimeException(e);}
    }
}
