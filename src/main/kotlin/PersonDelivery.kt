import dto.Person


class PersonDelivery {

    fun deliverPerson(): Person.Builder {
        val personBuilder = Person.newBuilder()
        personBuilder.email = "kalpesh@xyz.com"
        personBuilder.name = "kalpesh"
        return personBuilder
    }

    fun deliverPersonV2(): PersonV2 {
        return PersonV2("kalpesh")
    }


}