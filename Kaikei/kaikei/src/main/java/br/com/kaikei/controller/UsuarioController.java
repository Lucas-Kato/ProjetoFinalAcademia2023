package br.com.kaikei.controller;

import br.com.kaikei.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controladora responsável pela gestão de usuários.
 */
@AllArgsConstructor
@Controller
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Retorna a visualização da página de usuários.
     *
     * @return um objeto ModelAndView contendo a visualização da página e a lista de usuários.
     */
    @GetMapping()
    public ModelAndView viewUsuario() {
        ModelAndView modelAndView = new ModelAndView("usuarios");
        return modelAndView.addObject("listaUsuario", usuarioService.listarUsuarios());
    }

    /**
     * Retorna a visualização da página de edição de usuário.
     *
     * @param id o ID do usuário a ser editado
     * @return um objeto ModelAndView contendo a visualização da página e o usuário a ser editado.
     */

    @GetMapping("editar")
    public ModelAndView viewEditarUsuario(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("editarUsuario");
        return modelAndView.addObject("usuario", usuarioService.buscarPorId(id));
    }

    /**
     * Salva as alterações de um usuário.
     * @param id o ID do usuário a ser alterado
     * @param nome o novo nome do usuário
     * @param email o novo e-mail do usuário
     * @return um objeto ModelAndView para redirecionar para a página de usuário com uma mensagem de sucesso.
     */

    @PostMapping("/editar/salvar")
    public ModelAndView salvarAlteracao(@RequestParam Long id, @RequestParam String nome, @RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
        usuarioService.alterar(id, nome, email);
        return modelAndView.addObject("msgAlterado", "Usuário alterado com sucesso");
    }

    /**
     * Excluir um usuário
     * @param id o ID do usuário a ser excluído
     * @return um objeto ModelAndView para redirecionar para a página de usuário com uma mensagem de sucesso.
     */
    @GetMapping("/excluir")
    public ModelAndView excluirUsuario(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
        usuarioService.desativarUsuario(id);
        return modelAndView.addObject("msgExcluir", "Usuário foi excluido com sucesso");
    }

}
