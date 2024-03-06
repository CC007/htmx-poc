package com.github.cc007.htmxpocserver.components;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.cc007.htmxpocserver.components.content.DummyContentComponent;
import org.junit.jupiter.api.Test;

public class ComponentTest {

    @Test
    void getTemplateFileName_without_subpackage() {
        // prepare
        DummyComponent dummyComponent = new DummyComponent();

        // execute
        String actual = dummyComponent.getTemplateFileName();

        // verify
        assertThat(actual)
                .isEqualTo("com/github/cc007/htmxpocserver/components/DummyComponent.ftl");
    }

    @Test
    void getTemplateFileName_with_subpackage() {
        // prepare
        DummyContentComponent dummyContentComponent = new DummyContentComponent();

        // execute
        String actual = dummyContentComponent.getTemplateFileName();

        // verify
        assertThat(actual)
                .isEqualTo("com/github/cc007/htmxpocserver/components/content/DummyContentComponent.ftl");
    }

    @Test
    void getTemplateFileName_templateNotFound() {
        // prepare
        DummyComponentWithoutTemplate dummyComponentWithoutTemplate = new DummyComponentWithoutTemplate();

        // execute
        String actual = dummyComponentWithoutTemplate.getTemplateFileName();

        // verify
        assertThat(actual)
                .isEqualTo("com/github/cc007/htmxpocserver/components/error/500.ftl");
    }

    @Test
    void getTemplateName_without_subpackage() {
        // prepare
        DummyComponent dummyComponent = new DummyComponent();

        // execute
        String actual = dummyComponent.getTemplateName();

        // verify
        assertThat(actual)
                .isEqualTo("com/github/cc007/htmxpocserver/components/DummyComponent");
    }

    @Test
    void getTemplateName_with_subpackage() {
        // prepare
        DummyContentComponent dummyContentComponent = new DummyContentComponent();

        // execute
        String actual = dummyContentComponent.getTemplateName();

        // verify
        assertThat(actual)
                .isEqualTo("com/github/cc007/htmxpocserver/components/content/DummyContentComponent");
    }

    @Test
    void getTemplateName_templateNotFound() {
        // prepare
        DummyComponentWithoutTemplate dummyComponentWithoutTemplate = new DummyComponentWithoutTemplate();

        // execute
        String actual = dummyComponentWithoutTemplate.getTemplateName();

        // verify
        assertThat(actual)
                .isEqualTo("com/github/cc007/htmxpocserver/components/error/500");
    }
}