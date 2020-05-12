SELECT COUNT(*)
FROM personas JOIN tipo_documento ON personas.tipo_documento_id = tipo_documento.id
WHERE UPPER(tipo_documento.nombre) = UPPER(:tipo_documento)
AND personas.numero_documento = :numero_documento;