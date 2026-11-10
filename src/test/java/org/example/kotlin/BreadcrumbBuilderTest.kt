package org.example.kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BreadcrumbBuilderTest {

    private val allEntries = listOf(
        Entry(
            "Private", listOf(
                Entry(
                    "Privatkunden", listOf(
                        Entry(
                            "Zahlen & Sparen", listOf(
                                Entry("Sparkonto"),
                                Entry("Privatkonto")
                            )
                        )
                    )
                )
            )
        ),
        Entry(
            "Firmen", listOf(
                Entry("Firmenkunden")
            )
        )
    )

    @Test
    fun testAllBreadcrumbs() {
        //
        val allBreadCrumbs = BreadcrumbBuilder().buildAll(allEntries)

        Assertions.assertEquals(3, allBreadCrumbs.size)

        Assertions.assertTrue(allBreadCrumbs.contains("Private > Privatkunden > Zahlen & Sparen > Sparkonto"))
        Assertions.assertTrue(allBreadCrumbs.contains("Private > Privatkunden > Zahlen & Sparen > Privatkonto"))
        Assertions.assertTrue(allBreadCrumbs.contains("Firmen > Firmenkunden"))
    }

}
