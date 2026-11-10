package org.example.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class BreadcrumbBuilderTest {

  private static final List<Entry> ALL_ENTRIES = List.of(
      new Entry("Private", List.of(
          new Entry("Privatkunden", List.of(
              new Entry("Zahlen & Sparen", List.of(
                  new Entry("Sparkonto"),
                  new Entry("Privatkonto")
              )))))),
      new Entry("Firmen", List.of(
          new Entry("Firmenkunden")
      ))
  );

  @Test
  void testAllBreadcrumbs() {
    //
    List<String> allBreadCrumbs = BreadcrumbBuilder.buildAll(ALL_ENTRIES);

    assertEquals(3, allBreadCrumbs.size());

    assertTrue(allBreadCrumbs.contains("Private > Privatkunden > Zahlen & Sparen > Sparkonto"));
    assertTrue(allBreadCrumbs.contains("Private > Privatkunden > Zahlen & Sparen > Privatkonto"));
    assertTrue(allBreadCrumbs.contains("Firmen > Firmenkunden"));
  }
}
