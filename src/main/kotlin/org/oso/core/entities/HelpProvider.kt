package org.oso.core.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "hp")
data class HelpProvider(
//    @Id @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(nullable = false)
    @Size(min = 1)
    var id: String? = null,
    @Column(unique = true, nullable = false)
    @Size(min = 1)
    var name: String,
    @Column(unique = true, nullable = false)
    @Size(min = 1)
    var keycloakName: String,
    var expoPushToken: String? = null
) {
    @JsonBackReference
    @ManyToMany(mappedBy = "helpProviders")
    val helpRequesters = mutableSetOf<HelpRequester>()

    fun isAssignedTo(helpRequester: HelpRequester) =
        helpRequester.helpProviders.find { it.id == id } != null
}