package com.example.mercadolivro.model

import com.example.mercadolivro.enum.EnumBooks
import com.example.mercadolivro.enum.Erros
import com.example.mercadolivro.exception.BadRequestException
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BooksModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    //um usuario pode ter muitos livros
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

) {
    //data class possui um recurso  interessante, chamado set,garanto imutabilidade dos nossos valores.
    //Exemplo: Se o nosso estado do livro for cancelado ou deletado, devemos proibir esse status for alterado
    //então vamos usar um metodo set
    //data class  ja possui um construtor, para usar o set, extendi esse construtor e precisei criar outro
    @Column
    @Enumerated(EnumType.STRING)
    var status: EnumBooks? = null
        set(value) {
            if (field == EnumBooks.DELETADO || field == EnumBooks.CANCELADO)
                throw BadRequestException(Erros.ML_1002.message.format(field), Erros.ML_1002.code)
            field = value
        }
    //value e o valor que sera alterado
    //field e o valor atual presente na constante

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        status: EnumBooks?,
        customer: CustomerModel?
    ) : this(id, name, price, customer) {
        this.status = status
    }

}

