package nelsonssoares.ecomproductsapi.entrypoints;


import com.fasterxml.jackson.databind.ObjectMapper;
import nelsonssoares.ecomproductsapi.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SubCategoryController.class)
public class SubCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SubCategoryService subCategoryService;
}
