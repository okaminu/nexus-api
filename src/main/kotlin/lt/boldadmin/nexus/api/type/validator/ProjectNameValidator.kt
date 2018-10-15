package lt.boldadmin.nexus.api.type.validator

import javax.validation.ConstraintValidator

interface ProjectNameValidator: ConstraintValidator<UniqueProjectName, String>