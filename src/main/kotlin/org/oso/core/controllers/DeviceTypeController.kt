package org.oso.core.controllers

import org.oso.core.entities.DeviceType
import org.oso.core.services.DeviceTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(DeviceTypeController.PATH_DEVICE_TYPES)
class DeviceTypeController @Autowired constructor(private val deviceTypeService: DeviceTypeService){

    @GetMapping
    @ResponseBody
    fun findAll(): List<DeviceType> {
        return deviceTypeService.findAll()
    }

    companion object {
        const val PATH_DEVICE_TYPES = "devicetypes"
    }
}