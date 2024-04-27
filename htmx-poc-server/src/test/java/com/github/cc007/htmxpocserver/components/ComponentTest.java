package com.github.cc007.htmxpocserver.components;

import com.github.cc007.htmxpocserver.components.content.DummyContentComponent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComponentTest {

    @Test
    void getTemplateName_without_subpackage() {
        // prepare
        DummyComponent dummyComponent = new DummyComponent();

        // execute
        String actual = dummyComponent.getTemplateName(null, null);

        // verify
        assertThat(actual)
                .isEqualTo("DummyComponent");
    }

    @Test
    void getTemplateName_with_subpackage() {
        // prepare
        DummyContentComponent dummyContentComponent = new DummyContentComponent();

        // execute
        String actual = dummyContentComponent.getTemplateName(null, null);

        // verify
        assertThat(actual)
                .isEqualTo("content/DummyContentComponent");
    }

    @Test
    void getTemplateName_templateNotFound() {
        // prepare
        DummyComponentWithoutTemplate dummyComponentWithoutTemplate = new DummyComponentWithoutTemplate();

        // execute
        String actual = dummyComponentWithoutTemplate.getTemplateName(null, null);

        // verify
        assertThat(actual)
                .isEqualTo("content/error/Status500");
    }
}