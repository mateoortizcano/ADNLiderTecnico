select personas.id, personas.nombre, apellido, edad, tipo_documento.nombre as tipo_documento, numero_documento
from personas join tipo_documento on personas.tipo_documento_id = tipo_documento.id
where tipo_documento.nombre = :tipo_documento and numero_documento = :numero_documento;