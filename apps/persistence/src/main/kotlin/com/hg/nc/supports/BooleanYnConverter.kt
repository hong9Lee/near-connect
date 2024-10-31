package com.hg.nc.supports

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import org.apache.commons.lang3.BooleanUtils

@Converter
class BooleanYnConverter: AttributeConverter<Boolean, String> {
    override fun convertToDatabaseColumn(attribute: Boolean?): String {
        return if(BooleanUtils.isTrue(attribute)) "Y" else "N"
    }

    override fun convertToEntityAttribute(dbData: String?): Boolean {
        return "Y".equals(dbData, ignoreCase = true)
    }
}
