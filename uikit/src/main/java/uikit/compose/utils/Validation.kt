package uikit.compose.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

class Validation {

    fun isValidName(name: String): String {
        return if (name.isNotEmpty()) {
            if (Pattern.compile(
                    "/[a-zA-Z\\u00C0-\\u00FF ]+/i"
                ).matcher(name).matches()
            ) {
                "Nome ou Sobrenome não pode conter números ou caracteres especiais"
            } else {
                ""
            }
        } else {
            "Campo vazio"
        }
    }

    fun isValidEmail(email: String?): String {
        return if (!email.isNullOrEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                ""
            } else {
                "Campo de e-mail está inválido."
            }
        } else {
            "Campo de e-mail esta vazio."
        }
    }

    fun isValidPassword(password: String): String {
        return if (password.isNotEmpty()) {
            if (Pattern.compile(
                    "^(?=.*[A-Za-z])(?=.*d)(?=.*[@$!%*#?&])[A-Za-zd@$!%*#?&]{6,}$"
                ).matcher(password).matches()
            ) {
                "Senha deve conter no mínimo de seis caracteres, pelo menos uma letra, um número e um caractere especial"
            } else {
                ""
            }
        } else {
            "Campo vazio"
        }

    }

    fun isTelefone(telefone: String): String {
        return if (telefone.isNotEmpty()) {
            if (telefone.length >= 11) {
                ""
            } else {
                "Telefone incorreto"
            }
        } else {
            "Campo vazio"
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun isValidDataNascimento(date: String): String {

        if (date.isNotEmpty()) {
            if (date.length >= 8) {

                val calendarNasc: Calendar = Calendar.getInstance()
                calendarNasc.set(
                    date.substring(4, 8).toInt(),
                    date.substring(2, 3).toInt(),
                    date.substring(0, 1).toInt()
                )

                val calendarHoje: Calendar = Calendar.getInstance()
                val formataData = SimpleDateFormat("dd-MM-yyyy")
                val data = Date()
                val dataFormatada = formataData.format(data)

                calendarHoje.set(
                    dataFormatada.substring(6, 10).toInt(),
                    dataFormatada.substring(3, 5).toInt(),
                    dataFormatada.substring(0, 2).toInt()
                )

                val idade = calendarHoje.get(Calendar.YEAR) - calendarNasc.get(Calendar.YEAR) + 1

                if (idade < 18) {
                    return "Menor de idade"
                }
            } else {
                return "Data incorreta"
            }
        } else {
            return "Campo vazia"
        }
        return ""
    }

    fun isValidCPF(document: String): String {
        if (TextUtils.isEmpty(document)) return "Cpf vazio"

        val numbers = arrayListOf<Int>()

        document.filter { it.isDigit() }.forEach {
            numbers.add(it.toString().toInt())
        }

        if (numbers.size != 11) return "Cpf digitado incorreto"

        //repeticao
        (0..9).forEach { n ->
            val digits = arrayListOf<Int>()
            (0..10).forEach { digits.add(n) }
            if (numbers == digits) return "Cpf digitado incorreto"
        }

        //digito 1
        val dv1 = ((0..8).sumBy { (it + 1) * numbers[it] }).rem(11).let {
            if (it >= 10) 0 else it
        }

        val dv2 = ((0..8).sumBy { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
            if (it >= 10) 0 else it
        }

        return if (numbers[9] == dv1 && numbers[10] == dv2) {
            ""
        } else {
            "Cpf digitado incorreto"
        }
    }


    fun validateCPF(cpf: String): Boolean {
        if (cpf.length != 11) return false
        val numbers = cpf.replace("\\D".toRegex(), "")
        val dv1 = numbers[9].toString().toInt()
        val dv2 = numbers[10].toString().toInt()
        var soma = 0
        var resto = 0
        for (i in 0..8) {
            soma += numbers[i].toString().toInt() * (10 - i)
        }
        resto = 11 - (soma % 11)
        if (resto > 9) resto = 0
        if (resto != dv1) return false
        soma = 0
        for (i in 0..9) {
            soma += numbers[i].toString().toInt() * (11 - i)
        }
        resto = 11 - (soma % 11)
        if (resto > 9) resto = 0
        if (resto != dv2) return false
        return true
    }

    fun validateName(name: String): Boolean {
        return name.matches(RegexEnum.NAME.value)
    }

    fun validatePhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.matches(RegexEnum.PHONE_NUMBER.value)
    }

    fun validateEmail(email: String): Boolean {
        return email.matches(RegexEnum.EMAIL.value)
    }

    fun validatePassword(password: String): Boolean {
        return password.matches(RegexEnum.PASSWORD.value)
    }

}