package lt.boldadmin.nexus.api.type.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
annotation class UniqueProjectName(

    val message: String = "Duplicate project name",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)