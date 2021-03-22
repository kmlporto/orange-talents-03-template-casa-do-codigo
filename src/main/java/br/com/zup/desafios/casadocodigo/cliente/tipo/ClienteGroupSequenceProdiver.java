package br.com.zup.desafios.casadocodigo.cliente.tipo;

import br.com.zup.desafios.casadocodigo.cliente.ClientePersist;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteGroupSequenceProdiver implements DefaultGroupSequenceProvider<ClientePersist> {
    @Override
    public List<Class<?>> getValidationGroups(ClientePersist clientePersist) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClientePersist.class);

        if (clientePersist != null) {
            if (TipoPessoa.PF.equals(clientePersist.getTipoPessoa())) {
                groups.add(PessoaFisica.class);
            }else if (TipoPessoa.PJ.equals(clientePersist.getTipoPessoa())) {
                groups.add(PessoaJuridica.class);
            }
        }

        return groups;
    }
}
