package com.scholar.SGE.business

import com.scholar.SGE.model.Domicilio

interface IDomicilioBusiness {
    fun listDomicilios(): List<Domicilio>
    fun loadDomicilio(idDomicilio: Long): Domicilio
    fun saveDomicilio(Domicilio: Domicilio): Domicilio
    fun removeDomicilio(idDomicilio: Long)
}