
CREATE TABLE public.users_task (
	users_id bigserial NOT NULL,
	users_table_id bigserial NOT NULL,
	task_id bigserial NOT NULL,
	CONSTRAINT users_task_pkey PRIMARY KEY (users_table_id)
);


ALTER TABLE public.users_task ADD CONSTRAINT users_task_fk FOREIGN KEY (task_id) REFERENCES public.task(id);
ALTER TABLE public.users_task ADD CONSTRAINT users_task_fkey FOREIGN KEY (users_id) REFERENCES public.users(id);

ALTER TABLE public.users ADD CONSTRAINT users_login_unique UNIQUE (login);