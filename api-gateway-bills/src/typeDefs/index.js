//Se llama al typedef (esquema) de cada submodulo
const billTypeDefs = require('./bills_type_defs');
const bill_proTypeDefs = require('./bill_pro_type_defs');
//Se unen
const schemasArrays = [bill_proTypeDefs, billTypeDefs];
//Se exportan
module.exports = schemasArrays;