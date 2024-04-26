package com.github.cc007.htmxpocserver.components;

import com.github.cc007.htmxpocserver.components.content.DummyContentComponent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentTest {

    @Test
    void getTemplateFileName_without_subpackage() {
        // prepare
        DummyComponent dummyComponent = new DummyComponent();

        // execute
        String actual = dummyComponent.getTemplateFileName(null, null);

        // verify
        assertThat(actual)
                .isEqualTo("DummyComponent.ftl");
    }

    @Test
    void getTemplateFileName_with_subpackage() {
        // prepare
        DummyContentComponent dummyContentComponent = new DummyContentComponent();

        // execute
        String actual = dummyContentComponent.getTemplateFileName(null, null);

        // verify
        assertThat(actual)
                .isEqualTo("content/DummyContentComponent.ftl");
    }

    @Test
    void getTemplateFileName_templateNotFound() {
        // prepare
        DummyComponentWithoutTemplate dummyComponentWithoutTemplate = new DummyComponentWithoutTemplate();

        // execute
        String actual = dummyComponentWithoutTemplate.getTemplateFileName(null, null);

        // verify
        assertThat(actual)
                .isEqualTo("error/Status500.ftl");
    }

    @Test
    void getTemplateName_without_subpackage() {
        // prepare
        DummyComponent dummyComponent = new DummyComponent();

        // execute
        String actual = dummyComponent.getTemplateName();

        // verify
        assertThat(actual)
                .isEqualTo("DummyComponent");
    }

    @Test
    void getTemplateName_with_subpackage() {
        // prepare
        DummyContentComponent dummyContentComponent = new DummyContentComponent();

        // execute
        String actual = dummyContentComponent.getTemplateName();

        // verify
        assertThat(actual)
                .isEqualTo("content/DummyContentComponent");
    }

    @Test
    void getTemplateName_templateNotFound() {
        // prepare
        DummyComponentWithoutTemplate dummyComponentWithoutTemplate = new DummyComponentWithoutTemplate();

        // execute
        String actual = dummyComponentWithoutTemplate.getTemplateName();

        // verify
        assertThat(actual)
                .isEqualTo("error/Status500");
    }
}