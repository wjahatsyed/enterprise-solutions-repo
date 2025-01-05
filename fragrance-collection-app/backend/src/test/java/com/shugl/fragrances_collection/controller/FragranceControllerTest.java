package com.shugl.fragrances_collection.controller;

import com.shugl.fragrances_collection.entity.Fragrance;
import com.shugl.fragrances_collection.service.FragranceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FragranceController.class)
class FragranceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FragranceService fragranceService;

    private Fragrance sampleFragrance;

    @BeforeEach
    void setUp() {
        sampleFragrance = new Fragrance();
        sampleFragrance.setName("Vanilla Testing Fragrance");
        sampleFragrance.setBrand("Wjahat Adil Luxury Scents");
        sampleFragrance.setType("Vanilla");
    }

    @Test
    void testGetAll() throws Exception {
        List<Fragrance> fragrances = Arrays.asList(sampleFragrance);

        when(fragranceService.getAllFragrances()).thenReturn(fragrances);

        mockMvc.perform(get("/api/v1/fragrances"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Vanilla Testing Fragrance")))
                .andExpect(jsonPath("$[0].brand", is("Wjahat Adil Luxury Scents")));

        verify(fragranceService, times(1)).getAllFragrances();
    }

    @Test
    void testGetById() throws Exception {
        when(fragranceService.getFragranceById(1L)).thenReturn(sampleFragrance);

        mockMvc.perform(get("/api/v1/fragrances/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Vanilla Testing Fragrance")))
                .andExpect(jsonPath("$.brand", is("Wjahat Adil Luxury Scents")));

        verify(fragranceService, times(1)).getFragranceById(1L);
    }

    @Test
    void testCreate() throws Exception {
        when(fragranceService.createFragrance(Mockito.any(Fragrance.class))).thenReturn(sampleFragrance);

        mockMvc.perform(post("/api/v1/fragrances")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Vanilla Testing Fragrance\", \"brand\": \"Luxury Scents\", \"notes\": \"Citrus, Vanilla\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Vanilla Testing Fragrance")))
                .andExpect(jsonPath("$.brand", is("Wjahat Adil Luxury Scents")));

        verify(fragranceService, times(1)).createFragrance(Mockito.any(Fragrance.class));
    }

    @Test
    void testUpdate() throws Exception {
        when(fragranceService.updateFragrance(Mockito.eq(1L), Mockito.any(Fragrance.class))).thenReturn(sampleFragrance);

        mockMvc.perform(put("/api/v1/fragrances/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Vanilla Testing Fragrance\", \"brand\": \"Luxury Scents\", \"notes\": \"Citrus, Vanilla\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Vanilla Testing Fragrance")))
                .andExpect(jsonPath("$.brand", is("Wjahat Adil Luxury Scents")));

        verify(fragranceService, times(1)).updateFragrance(Mockito.eq(1L), Mockito.any(Fragrance.class));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/v1/fragrances/1"))
                .andExpect(status().isNoContent());

        verify(fragranceService, times(1)).deleteFragrance(1L);
    }
}
