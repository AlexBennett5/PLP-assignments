erlc src/names.erl
erlc test/namestest.erl
erl -noshell -s namestest start -s init stop
erl -noshell -s names start -s init stop
rm names.beam
rm namestest.beam
rm erl_crash.dump
