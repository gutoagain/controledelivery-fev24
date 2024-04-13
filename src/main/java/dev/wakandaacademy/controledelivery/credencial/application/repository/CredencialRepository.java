package dev.wakandaacademy.controledelivery.credencial.application.repository;

import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;

public interface CredencialRepository {
    Credencial salva(Credencial credencial);
}
